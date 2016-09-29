<%@ Page Title="" Language="C#" MasterPageFile="~/Master.Master" AutoEventWireup="true" CodeBehind="bookDetail.aspx.cs" Inherits="WebApplication1.bookDetail" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContent" runat="server">
    <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" DataSourceID="odsBook" Height="50px" Width="125px">
        <Fields>
            <asp:BoundField DataField="Id" HeaderText="Id" SortExpression="Id" />
            <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
            <asp:BoundField DataField="Author" HeaderText="Author" SortExpression="Author" />
            <asp:BoundField DataField="PublishDate" HeaderText="PublishDate" SortExpression="PublishDate" />
            <asp:BoundField DataField="ISBN" HeaderText="ISBN" SortExpression="ISBN" />
            <asp:BoundField DataField="WordsCount" HeaderText="WordsCount" SortExpression="WordsCount" />
            <asp:BoundField DataField="UnitPrice" HeaderText="UnitPrice" SortExpression="UnitPrice" />
            <asp:BoundField DataField="ContentDescription" HeaderText="ContentDescription" SortExpression="ContentDescription" />
            <asp:BoundField DataField="AurhorDescription" HeaderText="AurhorDescription" SortExpression="AurhorDescription" />
            <asp:BoundField DataField="EditorComment" HeaderText="EditorComment" SortExpression="EditorComment" />
            <asp:BoundField DataField="TOC" HeaderText="TOC" SortExpression="TOC" />
            <asp:BoundField DataField="Clicks" HeaderText="Clicks" SortExpression="Clicks" />
        </Fields>
    </asp:DetailsView>
    <asp:ObjectDataSource ID="odsBook" runat="server" SelectMethod="GetBookById" TypeName="MyBookShopBLL.BookManager">
        <SelectParameters>
            <asp:QueryStringParameter Name="id" QueryStringField="Id" Type="Int32" />
        </SelectParameters>
    </asp:ObjectDataSource>
</asp:Content>
