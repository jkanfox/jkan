<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="/commons/js/bootstrap.min.js"></script>
<#if scripts??>
  <#list scripts as script>
  <script src="${script}"></script>
  </#list>
</#if>
</body>
</html>