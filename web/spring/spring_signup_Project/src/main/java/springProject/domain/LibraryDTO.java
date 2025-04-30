package springProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("lib")
public class LibraryDTO {
	int libNum;
	String libSubject;
	String libWriter;
	String libContent;	
	String libImageOriginalName;
	String libImageStoreName;
	String libOriginalName;
	String libStoreName; 
	Date libRegist;
}













