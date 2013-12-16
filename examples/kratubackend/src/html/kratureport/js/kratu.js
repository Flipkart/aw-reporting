/**
 * @license Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



/**
 * The Kratu analysis engine
 * See examples/index.html for usage and more specifc information
 * @constructor
 */
function Kratu() {
  'use strict';
  var kratu = this;

  /**
   * Represents the report definition of this report
   * @private
   * @type {Object}
   */
  kratu.reportDefinition_ = null;

  /**
   * Entities to be analysed
   * @private
   * @type {Array<Object>}
   */
  kratu.entities_ = null;

  /**
   * Element containing the rendered report
   * @private
   * @type {Element}
   */
  kratu.renderElement_ = null;

  /**
   * State flag to tell wether we've already have a rendered report or not
   * @private
   * @type {boolean}
   */
  kratu.hasRendered_ = false;

  /**
   * Cache for already loaded scripts
   * @private
   * @type {Object<string,Element>}
   */
  kratu.loadedScripts_ = {};

  /**
   * The definitions of signals for this report
   * @private
   * @type {Object}
   */
  kratu.signalDefinitions_ = {};

  /**
   * The signals of this report
   * @private
   * @type {Array<KratuSignal>}
   */
  kratu.signals_ = [];

  /**
   * The disabled signals for this report
   * @private
   * @type {Object<string,boolean>}
   */
  kratu.disabledSignals_ = kratu.getPersistentSetting('disabledSignals', {});

  /**
   * Current page if using pagination
   * @private
   * @type {number}
   */
  kratu.currentPage_ = kratu.getPersistentSetting('currentPage', 1);

  /**
   * Page size if using pagination
   * @private
   * @type {number}
   */
  kratu.pageSize_ = null;

  /**
   * Sorted array of entities with calculated scores
   * @private
   * @type Array< {Object} >
   */
  kratu.calculatedEntities_ = [];

  /**
   * Array of summarylines to be rendered in the report
   * @private
   * @type Array< {Object} >
   */
  kratu.summaries_ = [];

  // Built in common presets
  kratu.formatters = kratu.getFormatters_();
  kratu.eventHandlers = kratu.getEventHandlers_();
  kratu.calculations = kratu.getCalculations_();
}


/**
 * Default heat map colors. Can be overriden by the report definition
 * @const {Object}
 */
Kratu.DEFAULT_HEAT_MAP = {
  neutral: 'rgb(255,255,255)',
  min: 'rgb(200,220,250)',
  max: 'rgb(0,160,200)'
};


