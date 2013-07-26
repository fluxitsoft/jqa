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
/**
 * JSON Simlet.
 */
Ext.define('Ext.ux.ajax.JsonSimlet', {
    extend: 'Ext.ux.ajax.DataSimlet',
    alias: 'simlet.json',

    doGet: function (ctx) {
        var me = this,
            data = me.getData(ctx),
            page = me.getPage(ctx, data),
            reader = ctx.xhr.options.proxy.reader,
            ret = me.callParent(arguments), // pick up status/statusText
            response = {};

        if (reader.root) {
            response[reader.root] = page;
            response[reader.totalProperty] = data.length;
        } else {
            response = page;
        }

        if (ctx.groupSpec) {
            response.summaryData = me.getSummary(ctx, data, page);
        }

        ret.responseText = Ext.encode(response);
        return ret;
    }
});
