<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="LoginForm.aspx.cs" Inherits="WebApplication1.Users.LoginForm" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContent" runat="server">
     
    <h1>用户登录</h1>
    
        <table style="width: 36%;">
            <tr>
                <td class="auto-style1">用户名</td>
                <td>
                    <asp:TextBox ID="txtLoginId" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">密码</td>
                <td>
                    <asp:TextBox ID="txtLoginPwd" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="登录" />
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    
   
   
</asp:Content>
