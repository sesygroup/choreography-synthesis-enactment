/*
 * Copyright 2017 The CHOReVOLUTION project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.syncope.client.console.panels;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.Marker;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Symbol;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.ZoomType;
import com.googlecode.wickedcharts.highcharts.options.series.Point;
import com.googlecode.wickedcharts.highcharts.options.series.RangeSeries;
import com.googlecode.wickedcharts.highcharts.options.series.Series;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.wicket7.highcharts.Chart;
import eu.chorevolution.idm.common.to.OperationDataTO;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import org.apache.syncope.client.console.rest.ChoreographyRestClient;
import org.apache.syncope.client.console.widgets.StatsWidget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class InstanceTimelinePanel extends Panel {

    private static final long serialVersionUID = 7125685319818097217L;

    private final ChoreographyRestClient restClient;

    private final TimelineBundle bundle;

    public InstanceTimelinePanel(final String id, final String instanceId) {
        super(id);

        this.restClient = new ChoreographyRestClient();

        List<OperationDataTO> operations = restClient.operationList(instanceId);

        WebMarkupContainer content = new WebMarkupContainer("charts");

        bundle = new TimelineBundle(operations);

        StatsWidget receivingTimeline = new StatsWidget("receivingServiceExecutionTimeline") {
            @Override
            public void create() {
                Options options = new Options();
                options.setChartOptions(new ChartOptions()
                        .setType(SeriesType.COLUMNRANGE)
                        .setInverted(Boolean.TRUE)
                        .setZoomType(ZoomType.Y)
                        .setAlignTicks(Boolean.TRUE));

                options.setTooltip(new Tooltip().setValueSuffix("ms"));
                options.setLegend(new Legend(Boolean.FALSE));
                options.setTitle(new Title("").setMargin(0));
                
                options.setxAxis(new Axis()
                        .setCategories(bundle.labels)
                        .setTitle(new Title("Operations")));

                options.setyAxis(new Axis().setTitle(new Title("Time (ms)")).setMin(0).setMax(bundle.lastEventLogged));

                RangeSeries serviceExecutionSeries = new RangeSeries();
                for (int i=0; i<bundle.labels.size(); i++) {
                    serviceExecutionSeries.addPoint(i, bundle.serviceReceivedTime.get(i), bundle.finishTime.get(i));
                }
                serviceExecutionSeries.setName("Receiving Services Execution");
                options.addSeries(serviceExecutionSeries);

                add(new Chart("chart", options));
                add(new Label("title", "Receiving Service Execution Timeline"));
                add(new Label("caption", ""));
            }
        };
        content.add(receivingTimeline);

        StatsWidget initiatingTimeline = new StatsWidget("initiatingServiceCallsTimeline") {
            @Override
            public void create() {
                Options options = new Options();
                options.setChartOptions(new ChartOptions()
                        .setType(SeriesType.SCATTER)
                        .setInverted(Boolean.TRUE)
                        .setZoomType(ZoomType.Y)
                        .setAlignTicks(Boolean.TRUE));

                options.setTooltip(new Tooltip().setValueSuffix("ms"));
                options.setLegend(new Legend(Boolean.FALSE));
                options.setTitle(new Title("").setMargin(0));
                
                options.setxAxis(new Axis()
                        .setCategories(bundle.labels)
                        .setTitle(new Title("Operations")));

                options.setyAxis(new Axis()
                        .setTitle(new Title("Time (ms)"))
                        .setMin(0)
                        .setMax(bundle.lastEventLogged));

                Series initiatingTimeSeries = new SimpleSeries();
                for (int i=0; i<bundle.labels.size(); i++) {
                    initiatingTimeSeries.addPoint(new Point(bundle.labels.get(i), bundle.initiatingTime.get(i)));
                }
                initiatingTimeSeries.setName("Initiating service call").setColor(Color.red);
                options.addSeries(initiatingTimeSeries);

                Series scheduleTimeSeries = new SimpleSeries();
                for (int i=0; i<bundle.labels.size(); i++) {
                    scheduleTimeSeries.addPoint(new Point(bundle.labels.get(i), bundle.schedulingTime.get(i)));
                }
                scheduleTimeSeries.setName("Operations schedule time").setColor(Color.green);
                //String tooltipFunction = "return \'Operation \' + this.key + \'scheduled by CD at \' + this.y;";
                //scheduleTimeSeries.setTooltip(new Tooltip().setFormatter(
                //        new Function(tooltipFunction)).setEnabled(true));
                options.addSeries(scheduleTimeSeries);

                Series discardingSeries = new SimpleSeries();
                for (int i=0; i<bundle.labels.size(); i++) {
                    discardingSeries.addPoint(new Point(bundle.labels.get(i), bundle.discardTime.get(i)));
                }
                discardingSeries.setName("Discarded operation time").setColor(Color.red).setMarker(
                        new Marker().setSymbol(new Symbol(
                                "http://fa2png.io/media/icons/font-awesome/4-7-0/times/12/0/ff0000_none.png")));
                options.addSeries(discardingSeries);

                add(new Chart("chart", options));
                add(new Label("title", "Initiating Services Calls Timeline"));
                add(new Label("caption", ""));
            }
        };
        content.add(initiatingTimeline);

        add(content);
    }

    private class TimelineBundle {

        private final long firstOperation;

        private final long lastEventLogged;

        private List<String> labels;

        private List<Number> initiatingTime;

        private List<Number> schedulingTime;

        private List<Number> serviceReceivedTime;

        private List<Number> finishTime;

        private List<Number> discardTime;

        public TimelineBundle(final List<OperationDataTO> operations) {

            // Order operations from the first called by the service to the last called
            Collections.sort(operations, new Comparator<OperationDataTO>() {
                @Override
                public int compare(OperationDataTO o1, OperationDataTO o2) {
                    return (int) (o1.getTimeCalledByInitiatingService() - o2.getTimeCalledByInitiatingService());
                }
            });

            firstOperation = operations.get(0).getTimeCalledByInitiatingService();
            normalizeTimes(operations);

            labels = new ArrayList<>();
            initiatingTime = new ArrayList<>();
            schedulingTime = new ArrayList<>();
            serviceReceivedTime = new ArrayList<>();
            finishTime = new ArrayList<>();
            discardTime = new ArrayList<>();

            long lastEventLogTemp = 0;

            for (OperationDataTO operation : operations) {
                labels.add(operation.getName());
                if(operation.getDiscardedOperations() > 0) {
                    discardTime.add(operation.getTimeReceivedByCD());
                } else {
                    discardTime.add(-10);
                }
                initiatingTime.add(operation.getTimeCalledByInitiatingService());
                schedulingTime.add(operation.getTimeScheduledByCD());
                serviceReceivedTime.add(operation.getTimeReceivedByCalledService());
                finishTime.add(operation.getTimeRepliedByCalledService());
                if(operation.getTimeReceivedByInitiatingService()>lastEventLogTemp) {
                    lastEventLogTemp = operation.getTimeReceivedByInitiatingService();
                }
            }

            lastEventLogged = lastEventLogTemp;
        }

        private void normalizeTimes(final List<OperationDataTO> operations) {
            for (OperationDataTO op : operations) {
                op.setTimeCalledByInitiatingService(op.getTimeCalledByInitiatingService() - firstOperation);
                op.setTimeReceivedByCalledService(op.getTimeReceivedByCalledService() - firstOperation);
                op.setTimeReceivedByCD(op.getTimeReceivedByCD() - firstOperation);
                op.setTimeScheduledByCD(op.getTimeScheduledByCD() - firstOperation);
                op.setTimeRepliedByCalledService(op.getTimeRepliedByCalledService() - firstOperation);
                op.setTimeReceivedByInitiatingService(op.getTimeReceivedByInitiatingService() - firstOperation);
            }
        }
    }

}
