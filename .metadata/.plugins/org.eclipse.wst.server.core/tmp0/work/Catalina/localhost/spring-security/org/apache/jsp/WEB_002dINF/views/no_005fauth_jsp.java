/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-02-02 13:21:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class no_005fauth_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/include/sidebar.jsp", Long.valueOf(1612267663935L));
    _jspx_dependants.put("/WEB-INF/include/navbar.jsp", Long.valueOf(1612271113958L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	pageContext.setAttribute("PATH", request.getContextPath());

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<title>武林秘籍管理系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/css/layui.css\">\r\n");
      out.write("</head> \r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("\t<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("\t\t<!-- 顶部导航 -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<div class=\"layui-header\">\r\n");
      out.write("\t<div class=\"layui-logo\" onclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main.html'\">武林秘籍管理系统</div>\r\n");
      out.write("\t<!-- 头部区域（可配合layui已有的水平导航） -->\r\n");
      out.write("\t<ul class=\"layui-nav layui-layout-left\">\r\n");
      out.write("\t\t<li class=\"layui-nav-item\"><a href=\"\">控制台</a></li>\r\n");
      out.write("\t\t<li class=\"layui-nav-item\"><a href=\"\">商品管理</a></li>\r\n");
      out.write("\t\t<li class=\"layui-nav-item\"><a href=\"\">用户</a></li>\r\n");
      out.write("\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\">其它系统</a>\r\n");
      out.write("\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<a href=\"\">邮件管理</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<a href=\"\">消息管理</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<a href=\"\">授权管理</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<ul class=\"layui-nav layui-layout-right\">\r\n");
      out.write("\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\"> <img\r\n");
      out.write("\t\t\t\tsrc=\"http://t.cn/RCzsdCq\" class=\"layui-nav-img\"> 张无忌\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<a href=\"\">基本资料</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<a href=\"\">安全设置</a>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl></li>\r\n");
      out.write("\t\t<li class=\"layui-nav-item\">\r\n");
      out.write("\t\t\t<!-- 禁用CSRF功能的前提下，最简单的退出方式 -->\t\t\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t <form id=\"logoutForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/do/logout.html\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<a id=\"logoutAnchor\" href=\"\">退出</a>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\twindow.onload = function() {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"logoutAnchor\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"logoutForm\").submit();\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t</script> \r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 侧边栏 -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<div class=\"layui-side layui-bg-black\">\r\n");
      out.write("\t<div class=\"layui-side-scroll\">\r\n");
      out.write("\t\t<!-- 左侧导航区域（可配合layui已有的垂直导航） -->\r\n");
      out.write("\t\t<ul class=\"layui-nav layui-nav-tree\" lay-filter=\"test\">\r\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a class=\"\"\r\n");
      out.write("\t\t\t\thref=\"javascript:;\">普通武功秘籍</a>\r\n");
      out.write("\t\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level1/1\">罗汉拳</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level1/2\">武当长拳</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level1/3\">全真剑法</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl></li>\r\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\">高级武功秘籍</a>\r\n");
      out.write("\t\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level2/1\">太极拳</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level2/2\">七伤拳</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level2/3\">梯云纵</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl></li>\r\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\">绝世武功秘籍</a>\r\n");
      out.write("\t\t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level3/1\">葵花宝典</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level3/2\">龟派气功</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/level3/3\">独孤九剑</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl></li>\r\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a href=\"#\">华山论剑</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"layui-body\">\r\n");
      out.write("\t\t\t<!-- 内容主体区域 -->\r\n");
      out.write("\t\t\t<div style=\"padding: 15px;\">\r\n");
      out.write("\t\t\t\t<h1>非常抱歉！您没有访问这个功能的权限！（回家照照镜子）</h1>\r\n");
      out.write("\t\t\t\t<h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-footer\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${PATH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/layui/layui.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//JavaScript代码区域\r\n");
      out.write("\t\tlayui.use('element', function() {\r\n");
      out.write("\t\t\tvar element = layui.element;\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
