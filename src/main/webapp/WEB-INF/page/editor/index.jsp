<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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

        <link rel="stylesheet" href="<%=basePath%>resources/css/edit/index.css">
        <link rel="stylesheet" href="<%=basePath%>resources/ui/semantic/v224.css">
        <script src="<%=basePath%>resources/lib/jquery/v180.js"></script>
        <script src="<%=basePath%>resources/ui/semantic/v224.js"></script>

        <style type="text/css" media="screen">
            #editor { 
                position: inherit;
                height: 70%;
                width: 80%;
            }
            .pusher>.ui.segment {
                padding: 1em; 
            }
        </style>
    </head>
    <body >

        <div class="ui visible sidebar inverted vertical menu very thin">
            <a class="item">
              1
            </a>
            <a class="item">
              2
            </a>
            <a class="item">
              3
            </a>
          </div>
        
        
        <div class="pusher">
            <div class="ui attached stackable menu">
                <div class="ui container">
                    <a class="item">
                        <i class="home icon"></i> 主页
                    </a>
                    <a class="item">
                        <i class="grid layout icon"></i> 浏览
                    </a>
                    <a class="item">
                        <i class="mail icon"></i> 信息
                    </a>aa
                    <div class="ui simple dropdown item">
                        更多
                        <i class="dropdown icon"></i>
                        <div class="menu">
                            <a class="item"><i class="edit icon"></i> 情况编辑</a>
                            <a class="item"><i class="globe icon"></i> 选择语言</a>
                            <a class="item"><i class="settings icon"></i> 账号设置</a>
                        </div>
                    </div>
                    <div class="right item">
                        <div class="ui input"><input type="text" placeholder="搜索..."></div>
                    </div>
                </div>
            </div>

            <div class="ui four column doubling stackable grid container">
                <div class="column">
                    <div class="ui list">
                <div class="item">
                    <i class="folder icon"></i>
                    <div class="content">
                        <div class="header">src</div>
                        <div class="list">
                            <div class="item">
                                <i class="folder icon"></i>
                                <div class="content">
                                    <div class="header">site</div>
                                </div>
                            </div>
                            <div class="item">
                                <i class="folder icon"></i>
                                <div class="content">
                                    <div class="header">themes</div>
                                    <div class="list">
                                        <div class="item">
                                            <i class="folder icon"></i>
                                            <div class="content">
                                                <div class="header">default</div>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <i class="folder icon"></i>
                                            <div class="content">
                                                <div class="header">my_theme</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <i class="file icon"></i>
                                <div class="content">
                                    <div class="header">theme.config</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <i class="folder icon"></i>
                    <div class="content">
                        <div class="header">dist</div>
                        <div class="list">
                            <div class="item">
                                <i class="folder icon"></i>
                                <div class="content">
                                    <div class="header">components</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <i class="file icon"></i>
                    <div class="content">
                        <div class="header">semantic.json</div>
                    </div>
                </div>
            </div>
                </div>
                <div class="column">
                    <div class="ui top attached tabular menu">
                <a class="item active" data-tab="first">第一</a>
                <a class="item" data-tab="second">第二</a>
                <a class="item" data-tab="third">第三</a>
            </div>
            <div class="ui bottom attached tab segment active" data-tab="first">
                <div id="editor"></div>
            </div>
            <div class="ui bottom attached tab segment" data-tab="second">
                第二
            </div>
            <div class="ui bottom attached tab segment" data-tab="third">
            </div>
                </div>
            </div>

            




            <script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.8/ace.js"></script>
            <script>
                var editor = ace.edit("editor");
                editor.setTheme("ace/theme/monokai");
                editor.getSession().setMode("ace/mode/javascript");
            </script>
        </div>
    </body>
</html>