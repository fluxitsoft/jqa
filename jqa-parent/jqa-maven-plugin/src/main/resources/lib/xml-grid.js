#-------------------------------------------------------------------------------
# Copyright (c) 2013 Flux IT.
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
Ext.Ajax.cors = true;
Ext.Ajax.useDefaultXhrHeader = false;

Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.ux.grid.FiltersFeature',
    'Ext.toolbar.Paging',
    'Ext.ux.ajax.JsonSimlet',
    'Ext.ux.ajax.SimManager'
]);

Ext.onReady(function(){
	
	Ext.ux.ajax.SimManager.init({
        delay: 300,
        defaultSimlet: null
    }).register({
        'myData': {
            data: [
               ['Blocker', 'Blocker'],
			   ['Critical', 'Critical'],
               ['Major', 'Major'],
               ['Minor', 'Minor'],
               ['Info', 'Info	']
            ],
            stype: 'json'
        }
    });
    
    var optionsPriority = Ext.create('Ext.data.Store', {
        fields: ['id', 'text'],
        proxy: {
            type: 'ajax',
            url: 'myData',
            reader: 'array'
        }
    });
    
    var filters = {
        ftype: 'filters',
        encode: false,
        local: true,   
        filters: [{
            type: 'boolean',
            dataIndex: 'visible'
        }]
    };
    
    // create the grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        features: [filters],
        columns: [
            {text: "Priority", width: 80, dataIndex: 'Priority', sortable: true, filter: { type: 'list', store: optionsPriority }},
            {text: "Rule", width: 180, dataIndex: 'Rule', sortable: true, filter: {type: 'string' }},
            {text: "Target class", width: 300, dataIndex: 'TargetClass', sortable: true, filter: {type: 'string' }},
            {text: "Message",  flex: 1,  dataIndex: 'Message', filter: {type: 'string' }}
        ],
        renderTo:'violations-grid',
        width: '100%',
        height: '90%'
    });
});
