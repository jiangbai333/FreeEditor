<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Hello spring</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
	
	
  </head>
  <body>
        <h1>Hello spring</h1>
		<div id="container" style="width:800px;height:600px;border:1px solid grey"></div>
		<script src="<%=basePath %>resources/javascript/edit/dev/vs/loader.js"></script>
		<script>
			var editor;
			require.config({ paths: { 'vs': './resources/javascript/edit/min/vs' }, 'vs/nls': { availableLanguages: { '*': 'zh-cn' } }});
			require(['vs/editor/editor.main'], function() {
				editor = monaco.editor.create(document.getElementById('container'), {
					value: [
						'import *',
						'public class test() {',
						'}'
					].join('\n'),
					theme: "vs-dark",
					language: 'java'
				});
			});
			
			//monaco.editor.setModelLanguage(editor.getModel(), "java") 
		</script>
  </body>
</html>