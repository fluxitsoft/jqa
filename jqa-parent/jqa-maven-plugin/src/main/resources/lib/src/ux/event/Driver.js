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
 * This is the base class for {@link Ext.ux.event.Recorder} and {@link Ext.ux.event.Player}.
 */
Ext.define('Ext.ux.event.Driver', {
    active: null,
    mixins: {
        observable: 'Ext.util.Observable'
    },

    constructor: function (config) {
        var me = this;

        me.mixins.observable.constructor.apply(this, arguments);

        me.addEvents(
            /**
             * @event start
             * Fires when this object is started.
             * @param {Ext.ux.event.Driver} this
             */
            'start',

            /**
             * @event stop
             * Fires when this object is stopped.
             * @param {Ext.ux.event.Driver} this
             */
            'stop'
        );
    },

    getTime: function () {
        return new Date().getTime();
    },

    /**
     * Returns the number of milliseconds since start was called.
     */
    getTimestamp: function () {
        var d = this.getTime();
        return d - this.startTime;
    },

    onStart: function () {},

    onStop: function () {},

    /**
     * Starts this object. If this object is already started, nothing happens.
     */
    start: function () {
        var me = this;

        if (!me.active) {
            me.active = new Date();
            me.startTime = me.getTime();
            me.onStart();
            me.fireEvent('start', me);
        }
    },

    /**
     * Stops this object. If this object is not started, nothing happens.
     */
    stop: function () {
        var me = this;

        if (me.active) {
            me.active = null;
            me.onStop();
            me.fireEvent('stop', me);
        }
    }
});
