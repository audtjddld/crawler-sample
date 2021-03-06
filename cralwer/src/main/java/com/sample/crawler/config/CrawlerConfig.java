package com.sample.crawler.config;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CrawlerConfig {

  @Bean
  @Scope("prototype")
  public CrawlController crawlController() throws Exception {
    CrawlConfig config = new CrawlConfig();
    config.setMaxDepthOfCrawling(3);
    config.setCrawlStorageFolder("backup");
    config.setUserAgentString("crawler-sample " + UUID.randomUUID());
    config.setPolitenessDelay(1500);

    PageFetcher pageFetcher = new PageFetcher(config);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);

    return new CrawlController(config, pageFetcher, robotstxtServer);
  }

}
