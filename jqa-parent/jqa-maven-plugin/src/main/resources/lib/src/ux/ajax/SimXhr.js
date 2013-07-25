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
 * @author Don Griffin
 *
 * Simulates an XMLHttpRequest object's methods and properties but is backed by a
 * {@link Ext.ux.ajax.Simlet} instance that provides the data.
 */
Ext.define('Ext.ux.ajax.SimXhr', {
    readyState: 0,

    mgr: null,
    simlet: null,

    constructor: function (config) {
        var me = this;

        Ext.apply(me, config);
        me.requestHeaders = {};
    },

    abort: function () {
        var me = this;

        if (me.timer) {
            clearTimeout(me.timer);
            me.timer = null;
        }
        me.aborted = true;
    },

    getAllResponseHeaders: function () {
        var headers = [];
        Ext.Object.each(this.responseHeaders, function (name, value) {
            headers.push(name + ': ' + value);
        });
        return headers.join('\x0d\x0a');
    },

    getResponseHeader: function (header) {
        var headers = this.responseHeaders;
        return (headers && headers[header]) || null;
    },

    open: function (method, url, async, user, password) {
        var me = this;
        me.method = method;
        me.url = url;
        me.async = async !== false;
        me.user = user;
        me.password = password;

        me.setReadyState(1);
    },

    overrideMimeType: function (mimeType) {
        this.mimeType = mimeType;
    },

    schedule: function () {
        var me = this;
        me.timer = setTimeout(function () {
            me.onTick();
        }, me.mgr.delay);
    },

    send: function (body) {
        var me = this;

        me.body = body;

        if (me.async) {
            me.schedule();
        } else {
            me.onComplete();
        }
    },

    setReadyState: function (state) {
        var me = this;
        if (me.readyState != state) {
            me.readyState = state;
            me.onreadystatechange();
        }
    },

    setRequestHeader: function (header, value) {
        this.requestHeaders[header] = value;
    },

    // handlers

    onreadystatechange: Ext.emptyFn,

    onComplete: function () {
        var me = this,
            callback;

        me.readyState = 4;
        Ext.apply(me, me.simlet.exec(me));

        callback = me.jsonpCallback;
        if (callback) {
            var text = callback + '(' + me.responseText + ')';
            eval(text);
        }
    },

    onTick: function () {
        var me = this;

        me.timer = null;
        me.onComplete();
        me.onreadystatechange();
    }
});
