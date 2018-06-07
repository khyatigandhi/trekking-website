/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkBlank(c1,msg)
{
    x=c1.value;
    l=x.length;
    if(l==0)
    {
        c1.focus();
        alert(msg);
        return false;
    }
    return true;
}
function checkPostal(c1,msg)
{
    x=c1.value;
    l=x.length;
    if(l!=6)
    {
        c1.focus();
        alert(msg);
        return false;
    }
    return true;
}
function checkPhone(c1,msg)
{
        x=c1.value;
    l=x.length;
    if(l!=10)
    {
        c1.focus();
        alert(msg);
        return false;
    }
    return true;

}


