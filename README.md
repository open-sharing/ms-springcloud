# 微服务之SpringCloud实践（Dalston.SR4版本)

各个模块的构建顺序和主要作用, 其中在入口类上通过"[关键代码]"注释每个组件的搭建注意事项

- eureka-server: 注册中心
- producer: 简单生产者
- ribbon-consumer: 通过ribbon负载均衡的服务消费
- feign-consumer: 通过feign声明式的服务消费
- hystrix-ribbon: 通过hystrix对负载均衡的服务消费进行容错降级
- hystrix-feign:  通过hystrix对声明式的服务消费进行容错降级
- hystrix-dashboard: Hystrix监控面板
- hystrix-turbine: 通过turbine进行集群监控
- hystrix-ribbon-rabbitmq: 通过hystrix对负载均衡的服务消费进行容错降级, 并通过消息中间件rabbitmq进行集群监控数据发布
- hystrix-turbine-rabbitmq: 通过turbine进行集群监控, 并通过消息中间件rabbitmq进行集群监控数据收集