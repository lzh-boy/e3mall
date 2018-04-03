# 服务器地址
halt

### 192.168.21.101	root 123456
```
安装软件：jdk、mysql、tomcat、redis、zookeeper
ps aux|grep tomcat
/usr/local/tomcats/apache-tomcat-8.5.28/bin/startup.sh
/usr/local/tomcats/apache-tomcat-8.5.28/bin/shutdown.sh

zookeeper 单机
ps aux|grep zookeeper
/usr/local/zookeeper-3.4.6/bin/zkServer.sh start
/usr/local/zookeeper-3.4.6/bin/zkServer.sh stop
/usr/local/zookeeper-3.4.6/bin/zkServer.sh status
http://192.168.21.101:8080/dubbo-admin/
```



### 192.168.21.102 root 123456
```
安装软件：jdk、activeMQ
activemq 消息队列
ps aux|grep activemq
/usr/local/activeMQ/apache-activemq-5.12.0/bin/activemq start
/usr/local/activeMQ/apache-activemq-5.12.0/bin/activemq stop
/usr/local/activeMQ/apache-activemq-5.12.0/bin/activemq status
http://192.168.21.102:8161/
```



### 192.168.21.103 root 123456
```
安装软件：jdk、tomcat、redis单机、redis集群、solr单机
redis 单机
ps aux|grep redis
/usr/local/redis3.0/bin/redis-server /usr/local/redis3.0/bin/redis.conf
/usr/local/redis3.0/bin/redis-cli -h 192.168.21.103 -p 6379
ping PONG 健康检查
/usr/local/redis3.0/bin/redis-cli shutdown

redis 集群
ps aux|grep cluster
/usr/local/redis3.0/redis-cluster/start-redis-cluster-all.sh
/usr/local/redis3.0/redis-cluster/stop-redis-cluster-all.sh

solr 单机
ps aux|grep tomcat
/usr/local/solr/apache-tomcat-8.0.50/bin/startup.sh
/usr/local/solr/apache-tomcat-8.0.50/bin/shutdown.sh

http://192.168.21.103:8080/solr/#/

zookeeper 集群
ps aux|grep solr-cloud/zookeeper-
/usr/local/solr-cloud/start-zookeeper-all.sh
/usr/local/solr-cloud/stop-zookeeper-all.sh

tomcat 集群
ps aux|grep solr-cloud/tomcat-
/usr/local/solr-cloud/start-tomcat-all.sh
/usr/local/solr-cloud/stop-tomcat-all.sh
http://192.168.21.103:8180/solr/#/       8180,8280,8380,8480
```



### 192.168.21.110 root 123456
```
安装软件：nginx、fastDFS、nginx插件
ps aux|grep tracker
/usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf
/usr/bin/fdfs_trackerd /etc/fdfs/tracker.conf restart
killall fdfs_trackerd

ps aux|grep storage
/usr/bin/fdfs_storaged /etc/fdfs/storage.conf
/usr/bin/fdfs_storaged /etc/fdfs/storage.conf restart
killall fdfs_storaged

ps aux|grep nginx
/usr/local/nginx/sbin/nginx
/usr/local/nginx/sbin/nginx -s quit
/usr/local/nginx/sbin/nginx -s stop
/usr/local/nginx/sbin/nginx -s reload
```
