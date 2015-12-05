package beansPackage;
/*
 * DataStore.java
 *
 * Created on 13 de diciembre de 2005, 14:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */



import java.util.*;

/**
 *
 * @author telmoz
 */
public class DataStore {
 
  // HashMap of DataModelBean objects keyed by user name
  private static Map dataMap = new HashMap();
  private static Map dataMapAdmin = new HashMap();
  private static Map coursesMap = new HashMap();

  static {
    dataMap.put("rym", new StudentBean("rym","Rick","Sanchez","","","password","Fuck yo momma","img/profile/rick.png",'0',56,"","",""));
    dataMap.put("professor", new TeacherBean("professor","Caraculo","","","","password","","img/profile/user.svg",'1',5,"",0));
    dataMapAdmin.put("admin", new AdminBean("admin","admin"));
    coursesMap.put("learning cocina", new CourseBean("learning cocina", 0, 0, "learning cocina", null, null, null, null, null, null, 0, 0, true, false));
    coursesMap.put("learning programming", new CourseBean("learning programming", 0, 0, "learning programming", null, null, null, null, null, null, 0, 0, false, false));
    coursesMap.put("learning tiw", new CourseBean("learning tiw", 0, 0, "learning tiw", null, null, null, null, null, null, 0, 0, false, false));
  }

  // Creates new DataStore
  public DataStore() {
  }

  public UserBean getInfo(String id) {
    return (UserBean) dataMap.get(id);
  }

  public void putInfo(String id,Object object) {
	  dataMap.put(id,object);
  }
  
  public AdminBean getAdmin(String id){
	  return (AdminBean) dataMapAdmin.get(id);
  }
  
  /*Returns, in form of Arraylist of objects, the courses of the teachers*/
  public ArrayList<Object> getCourses(){
	  return new ArrayList<Object>(coursesMap.values());
  }
  
  public ArrayList<Object> getUsers(){
	  return new ArrayList<Object>(dataMap.values());
  }
  
  public CourseBean getCourse(String id){
	  return (CourseBean) coursesMap.get(id);
  }
  
  public void deleteCourse(String id , CourseBean a){
	  coursesMap.remove(id, a);
  }
  
  public void deleteUser(String id , UserBean a){
	  dataMap.remove(id, a);
  }
  
  public boolean aprooveCourse(String id ,CourseBean a ,CourseBean b ){
	  return coursesMap.replace(id, a, b);
  }
  
//  public boolean highlightCourse(String id , ){
//	  return coursesMap.replace(id, 0, 1);
//  }
}