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
 * A Grid which creates itself from an existing HTML table element.
 */
Ext.define('Ext.ux.grid.TransformGrid', {
    extend: 'Ext.grid.Panel',

    /**
     * Creates the grid from HTML table element.
     * @param {String/HTMLElement/Ext.Element} table The table element from which this grid will be created -
     * The table MUST have some type of size defined for the grid to fill. The container will be
     * automatically set to position relative if it isn't already.
     * @param {Object} [config] A config object that sets properties on this grid and has two additional (optional)
     * properties: fields and columns which allow for customizing data fields and columns for this grid.
     */
    constructor: function(table, config) {
        config = Ext.apply({}, config);
        table = this.table = Ext.get(table);

        var configFields = config.fields || [],
            configColumns = config.columns || [],
            fields = [],
            cols = [],
            headers = table.query("thead th"),
            i = 0,
            len = headers.length,
            data = table.dom,
            width,
            height,
            store,
            col,
            text,
            name;

        for (; i < len; ++i) {
            col = headers[i];

            text = col.innerHTML;
            name = 'tcol-' + i;

            fields.push(Ext.applyIf(configFields[i] || {}, {
                name: name,
                mapping: 'td:nth(' + (i + 1) + ')/@innerHTML'
            }));

            cols.push(Ext.applyIf(configColumns[i] || {}, {
                text: text,
                dataIndex: name,
                width: col.offsetWidth,
                tooltip: col.title,
                sortable: true
            }));
        }

        if (config.width) {
            width = config.width;
        } else {
            width = table.getWidth() + 1;
        }

        if (config.height) {
            height = config.height;
        }

        Ext.applyIf(config, {
            store: {
                data: data,
                fields: fields,
                proxy: {
                    type: 'memory',
                    reader: {
                        record: 'tbody tr',
                        type: 'xml'
                    }
                }
            },
            columns: cols,
            width: width,
            height: height
        });
        this.callParent([config]);
        
        if (config.remove !== false) {
            // Don't use table.remove() as that destroys the row/cell data in the table in
            // IE6-7 so it cannot be read by the data reader.
            data.parentNode.removeChild(data);
        }
    },

    onDestroy: function() {
        this.callParent();
        this.table.remove();
        delete this.table;
    }
});
