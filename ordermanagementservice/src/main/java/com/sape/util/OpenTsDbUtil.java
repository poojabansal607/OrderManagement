package com.sape.util;

import com.codahale.metrics.Clock;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.metrics.service.OpenTsdb;
import com.metrics.service.OpenTsdbReporter;
import jersey.repackaged.com.google.common.collect.ImmutableMap;

import java.lang.management.ManagementFactory;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by asi234 on 4/8/2016.
 */
public class OpenTsDbUtil {
    private final String url;
    private final MetricRegistry registry;
    private final OpenTsdb openTsdb;
    private final OpenTsdbReporter reporter;
    private int batchSize;

    public OpenTsDbUtil(MetricRegistry registry, String url) {
        this.registry = registry;
        this.url = url;
        openTsdb = OpenTsdb.forService(url).create();
        reporter = OpenTsdbReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .withTags(getServerTags())
                .withBatchSize(10)
                .build(openTsdb);
    }

    public void start() {
        registerJvmMetrics();
        reporter.start(120, TimeUnit.SECONDS);
    }

    public void stop() {
        reporter.stop();
    }

    public void registerJvmMetrics() {
        registry.register("jvm.memory", new MemoryUsageGaugeSet());
        registry.register("jvm.gc", new GarbageCollectorMetricSet());
        registry.register("jvm.thread", new ThreadStatesGaugeSet());
       /* registry.register("jvm.cpu", new CpuGaugeSet());
        registry.register("jvm.runtime", new RuntimeGaugeSet());*/
    }

    private ImmutableMap<String,String>getServerTags(){
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        int marker = vmName.indexOf("@");
        String host = vmName.substring(marker+1);
        return ImmutableMap.of("host",host);
    }
}
