# 本项目为光大35万积分活动所写 #
主要代码在com.haibo.test.service.impl.HttpRequestServiceImpl

其中customer参数为加密后的用户id，可以通过fiddler抓包得到，也可以通过数据库配置在t_customer表中；

代码很简单，采用springboot开发，使用Scheduled定时100毫秒执行一次，实时判断排名，如果排名为87，887，8887,88887,888887，就调用http post请求点亮接口；由于请求时间断，可能会出现超时Connection timed out: connect情况，这属正常。

小功能：如接近排名点支持邮件，声音提醒，可以自己配置；

![](https://i.imgur.com/131BxTF.jpg)

![](https://i.imgur.com/m2nPBMa.jpg)