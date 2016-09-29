<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AddBook.aspx.cs" Inherits="WebApplication1.AddBook" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 20px;
            width: 426px;
        }
        .auto-style2 {
            width: 86px;
        }


        .auto-style3 {
            width: 86px;
            height: 20px;
        }


    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <table style="width: 38%;">
            <tr>
                <td class="auto-style2">标题</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">作者</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtAuthor" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">出版商</td>
                <td class="auto-style1">
                    <asp:DropDownList ID="ddlPublisherId" runat="server">
                    </asp:DropDownList>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">出版日期</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtpublishDate" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">ISBN</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtISBN" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">字数</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtWordsCount" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">单价</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtUnitPrice" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">简介</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtContentDescription" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">作者介绍</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtAurhorDescription" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">评价</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtEditorComment" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">目录</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtToc" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">类别</td>
                <td class="auto-style1">
                    <asp:DropDownList ID="ddlCategoryId" runat="server">
                    </asp:DropDownList>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">点击量</td>
                <td class="auto-style1">
                    <asp:TextBox ID="txtClicks" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">&nbsp;</td>
                <td class="auto-style1">
                    <asp:Button ID="btnOK" runat="server" OnClick="btnOK_Click" Text="添加书本" />
                </td>
            </tr>
        </table>
    
    </div>
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    </form>
</body>
</html>
