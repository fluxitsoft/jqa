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
 * This class simulates XML-based requests.
 */
Ext.define('Ext.ux.ajax.XmlSimlet', {
    extend: 'Ext.ux.ajax.DataSimlet',
    alias: 'simlet.xml',

    /**
     * This template is used to populate the XML response. The configuration of the Reader
     * is available so that its `root` and `record` properties can be used as well as the
     * `fields` of the associated `model`. But beyond that, the way these pieces are put
     * together in the document requires the flexibility of a template.
     */
    xmlTpl: [
        '<{root}>\n',
            '<tpl for="data">',
        '    <{parent.record}>\n',
                '<tpl for="parent.fields">',
        '        <{name}>{[parent[values.name]]}</{name}>\n',
                '</tpl>',
        '    </{parent.record}>\n',
            '</tpl>',
        '</{root}>'
    ],

    doGet: function (ctx) {
        var me = this,
            data = me.getData(ctx),
            page = me.getPage(ctx, data),
            reader = ctx.xhr.options.proxy.reader,
            ret = me.callParent(arguments), // pick up status/statusText
            response = {
                data: page,
                reader: reader,
                fields: reader.model.getFields(),
                root: reader.root,
                record: reader.record
            };

        if (ctx.groupSpec) {
            response.summaryData = me.getSummary(ctx, data, page);
        }

        var tpl = Ext.XTemplate.getTpl(me, 'xmlTpl'),
            xml = tpl.apply(response),
            doc;

        if (typeof DOMParser != 'undefined') {
            doc = (new DOMParser()).parseFromString(xml, "text/xml");
        } else {
            // IE doesn't have DOMParser, but fortunately, there is an ActiveX for XML
            doc = new ActiveXObject("Microsoft.XMLDOM");
            doc.async = false;
            doc.loadXML(xml);
        }

        ret.responseText = xml;
        ret.responseXML = doc;
        return ret;
    }
});
