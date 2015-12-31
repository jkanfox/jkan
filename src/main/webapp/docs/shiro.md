第一步：配置Shiro核心过滤器 web.xml

```
<!-- SHIRO Filter Settings -->
<filter>
	<filter-name>shiroFilter</filter-name>
	<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
	<filter-name>shiroFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```