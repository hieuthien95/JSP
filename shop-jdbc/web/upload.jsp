<form method="post" action="UploadServlet" enctype="multipart/form-data">
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="Upload" />
</form>

<h2>URL image: ${message}</h2>
<img width="300" src="${message}"/>