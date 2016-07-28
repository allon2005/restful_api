package userManagement;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "user")
/*
 * Maps a class or an enum type to an XML element. 
The @XmlRootElement annotation can be used with the following program elements:
    a top level class
    an enum type
 */
public class User implements Serializable {

   private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private String profession;

   public User(){}
   
   public User(int id, String name, String profession){
      this.id = id;
      this.name = name;
      this.profession = profession;
   }

   public int getId() {
      return id;
   }

   @XmlElement  //only put to setter!!!
   /* A container for multiple @XmlElement annotations. Multiple annotations of the same type are not allowed on a program element. This annotation therefore serves as a container annotation for multiple @XmlElements as follows:

 @XmlElements({ @XmlElement(...),@XmlElement(...) })
 

The @XmlElements annnotation can be used with the following program elements:

    a JavaBean property
    non static, non transient field

This annotation is intended for annotation a JavaBean collection property (e.g. List). 
    * 
    */
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   @XmlElement
   public void setName(String name) {
      this.name = name;
   }
   public String getProfession() {
      return profession;
   }
   @XmlElement
   public void setProfession(String profession) {
      this.profession = profession;
   }		
}