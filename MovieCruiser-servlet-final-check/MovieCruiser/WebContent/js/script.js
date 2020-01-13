function validateMoviesForm(){
	var title=document.forms["editmovie"]["title"].value;
    if(title==""){
        alert('Title is required');
        return false;
    }
    var titleLength=title.length;
    if(title.length<2 || title.length>100)
    {
        alert('Title should have 2 to 100 characters');
        return false;
    }
    var gross=document.forms["editmovie"]["gross"].value;
    
    if(isNaN(gross))
    {
        alert('Gross has to be a number');
        return false;
    }
    if(gross==""){
        alert('Gross is required');
        return false;
    }
    var dateOfLaunch=document.forms["editmovie"]["dateOfLaunch"].value;
    if(dateOfLaunch==""){
        alert("Date of Launch is required");
        return false;
    }
    if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/))
    {
        alert("Incorrect date format. Expected format (dd/mm/yyyy)");
        return false;
    }
}
     
    
    
    