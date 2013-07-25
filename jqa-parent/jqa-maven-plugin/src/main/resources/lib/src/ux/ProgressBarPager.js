#-------------------------------------------------------------------------------
# Copyright (c) 2011 Juan Ignacio Barisich.
# 
# This file is part of JQA (http://github.com/fluxitsoft/jqa).
# 
# JQA is free software: you can redistribute it and/or modify it 
# under the terms of the GNU Lesser General Public License as 
# published by the Free Software Foundation, either version 3 of 
# the License, or (at your option) any later version.
# 
# JQA is distributed in the hope that it will be useful, but WITHOUT 
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
# or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
# Public License for more details.
# 
# You should have received a copy of the GNU Lesser General Public 
# License along with JQA. If not, see <http://www.gnu.org/licenses/>.
#-------------------------------------------------------------------------------
/**
* @class Ext.ux.ProgressBarPager
* @extends Object
* Plugin for displaying a progressbar inside of a paging toolbar instead of plain text
* @constructor
* Create a new ProgressBarPager
* @param {Object} config Configuration options
*/
Ext.define('Ext.ux.ProgressBarPager', {

    requires: ['Ext.ProgressBar'],
    /**
     * @cfg {Number} width
     * <p>The default progress bar width.  Default is 225.</p>
    */
    width   : 225,
    /**
     * @cfg {String} defaultText
    * <p>The text to display while the store is loading.  Default is 'Loading...'</p>
     */
    defaultText    : 'Loading...',
    /**
     * @cfg {Object} defaultAnimCfg
     * <p>A {@link Ext.fx.Anim Ext.fx.Anim} configuration object.</p>
     */
    defaultAnimCfg : {
		duration: 1000,
		easing: 'bounceOut'	
	},	
    
    constructor : function(config) {
        if (config) {
            Ext.apply(this, config);
        }
    },
    //public
    init : function (parent) {
        var displayItem;
        if (parent.displayInfo) {
            this.parent = parent;

            displayItem = parent.child("#displayItem");
            if (displayItem) {
                parent.remove(displayItem, true);
            }

            this.progressBar = Ext.create('Ext.ProgressBar', {
                text    : this.defaultText,
                width   : this.width,
                animate : this.defaultAnimCfg,
                style: {
                    cursor: 'pointer'
                },
                listeners: {
                    el: {
                        scope: this,
                        click: this.handleProgressBarClick
                    }
                }
            });

            parent.displayItem = this.progressBar;

            parent.add(parent.displayItem);
            Ext.apply(parent, this.parentOverrides);
        }
    },
    // private
    // This method handles the click for the progress bar
    handleProgressBarClick : function(e){
        var parent = this.parent,
            displayItem = parent.displayItem,
            box = this.progressBar.getBox(),
            xy = e.getXY(),
            position = xy[0]- box.x,
            pages = Math.ceil(parent.store.getTotalCount() / parent.pageSize),
            newPage = Math.max(Math.ceil(position / (displayItem.width / pages)), 1);

        parent.store.loadPage(newPage);
    },

    // private, overriddes
    parentOverrides  : {
        // private
        // This method updates the information via the progress bar.
        updateInfo : function(){
            if(this.displayItem){
                var count = this.store.getCount(),
                    pageData = this.getPageData(),
                    message = count === 0 ?
                    this.emptyMsg :
                    Ext.String.format(
                        this.displayMsg,
                        pageData.fromRecord, pageData.toRecord, this.store.getTotalCount()
                    ),
                    percentage = pageData.pageCount > 0 ? (pageData.currentPage / pageData.pageCount) : 0;

                this.displayItem.updateProgress(percentage, message, this.animate || this.defaultAnimConfig);
            }
        }
    }
});

