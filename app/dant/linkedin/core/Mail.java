package dant.linkedin.core;

import java.util.List;

public class Mail
{
  public List<String> dests;
  public String msg;
  public String obj;
  public String filePath;
  public String fileName;
  
  @Override
  public String toString()
  {
    return "Mail [dests=" + dests + ", msg=" + msg + ", obj=" + obj + ", filePath=" + filePath + ", fileName="
        + fileName + "]";
  }

  public List<String> getDests()
  {
    return dests;
  }

  public void setDests(List<String> dests)
  {
    this.dests = dests;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public String getObj()
  {
    return obj;
  }

  public void setObj(String obj)
  {
    this.obj = obj;
  }

  public String getFilePath()
  {
    return filePath;
  }

  public void setFilePath(String filePath)
  {
    this.filePath = filePath;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  
  

}