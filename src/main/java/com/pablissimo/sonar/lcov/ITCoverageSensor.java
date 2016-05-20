/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.pablissimo.sonar.lcov;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.CoreMetrics;

import com.pablissimo.sonar.TypeScriptPlugin;

public class ITCoverageSensor extends LCOVCoverageSensor {

  public ITCoverageSensor(FileSystem fileSystem, Settings settings) {
    super(fileSystem, settings);
    linesToCoverMetric = CoreMetrics.IT_LINES_TO_COVER;
    uncoveredLinesMetric = CoreMetrics.IT_UNCOVERED_LINES;
    coverageLineHitsDataMetric = CoreMetrics.IT_COVERAGE_LINE_HITS_DATA;
    reportPaths = new String[]{ TypeScriptPlugin.SETTING_LCOV_IT_REPORT_PATH };
    coveredConditionsByLineMetric = CoreMetrics.IT_COVERED_CONDITIONS_BY_LINE;
    conditionsByLineMetric = CoreMetrics.IT_CONDITIONS_BY_LINE;
    uncoveredConditionsMetric = CoreMetrics.IT_UNCOVERED_CONDITIONS;
    conditionsToCoverMetric = CoreMetrics.IT_CONDITIONS_TO_COVER;
  }

}
