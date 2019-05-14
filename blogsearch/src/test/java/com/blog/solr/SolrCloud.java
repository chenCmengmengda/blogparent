package com.blog.solr;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloud {
    @Test
    public void testAddDocument() throws Exception {
        //创建一个和solr集群的连接
        //参数就是zookeeper的地址列表，使用逗号分隔
        String zkHost = "119.29.130.199:2181,119.29.130.199:2182,119.29.130.199:2183";
        CloudSolrServer solrServer = new CloudSolrServer(zkHost);
        //设置默认的collection
        solrServer.setDefaultCollection("collection1");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        //向文档中添加域
        document.addField("id", "test001");
        document.addField("blog_title", "测试");
        //把文档添加到索引库
        solrServer.add(document);
        //提交
        solrServer.commit();
    }

}
