/*
 * Sonar SCM Stats Plugin
 * Copyright (C) 2012 Patroklos PAPAPETROU
 * dev@sonar.codehaus.org
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package org.sonar.plugins.scmstats.measures;

import java.util.Map;
import org.joda.time.DateTime;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.measures.Metric;

public class CommitsPerWeekDayMeasure extends AbstractScmStatsMeasure {
  
  public CommitsPerWeekDayMeasure(
                                final Metric metric,
                                final Map<String, Integer> map, 
                                final SensorContext context) {
    super(metric, map, context);
  }

  @Override
  protected void init() {
    for (int i = 1; i <= 7; i++) {
      DateTime dt = new DateTime(2012, 1, i, 0, 0);
      getDataMap().put(dt.dayOfWeek().getAsString(), 0);
    }
  }
}