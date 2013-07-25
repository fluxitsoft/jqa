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
* @class Ext.ux.SlidingPager
* @extends Object
* Plugin for PagingToolbar which replaces the textfield input with a slider
* @constructor
* Create a new ItemSelector
* @param {Object} config Configuration options
*/
Ext.define('Ext.ux.SlidingPager', {
    requires: [
        'Ext.slider.Single',
        'Ext.slider.Tip'
    ],

    constructor : function(config) {
        if (config) {
            Ext.apply(this, config);
        }
    },

    init : function(pbar){
        var idx = pbar.items.indexOf(pbar.child("#inputItem")),
            slider;

        Ext.each(pbar.items.getRange(idx - 2, idx + 2), function(c){
            c.hide();
        });

        slider = Ext.create('Ext.slider.Single', {
            width: 114,
            minValue: 1,
            maxValue: 1,
            hideLabel: true,
            tipText: function(thumb) {
                return Ext.String.format('Page <b>{0}</b> of <b>{1}</b>', thumb.value, thumb.slider.maxValue);
            },
            listeners: {
                changecomplete: function(s, v){
                    pbar.store.loadPage(v);
                }
            }
        });

        pbar.insert(idx + 1, slider);

        pbar.on({
            change: function(pb, data){
                slider.setMaxValue(data.pageCount);
                slider.setValue(data.currentPage);
            }
        });
    }
});
