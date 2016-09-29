<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="AddBook.aspx.cs" Inherits="WebApplication1.Admin.AddBook" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContent" runat="server">
    
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
    
</asp:Content>
