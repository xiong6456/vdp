<%
    if(request.getAttribute("LUI_ContextPath")==null){
        String LUI_ContextPath = request.getContextPath();
        request.setAttribute("LUI_ContextPath", LUI_ContextPath);
        request.setAttribute("KMSS_Parameter_Style", "default");
        request.setAttribute("KMSS_Parameter_ContextPath", LUI_ContextPath+"/");
        request.setAttribute("KMSS_Parameter_ResPath", LUI_ContextPath+"/resource/");
        request.setAttribute("KMSS_Parameter_StylePath", LUI_ContextPath+"/resource/style/default/");
    }
%>