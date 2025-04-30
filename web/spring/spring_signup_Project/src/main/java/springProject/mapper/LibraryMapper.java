package springProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springProject.domain.LibraryDTO;
import springProject.domain.StartEndPageDTO;

@Mapper
public interface LibraryMapper {
	public int libraryInsert(LibraryDTO dto);
	public List<LibraryDTO> libSelectList(StartEndPageDTO sepDTO );// #{arg0} , 
	public LibraryDTO libSelectOne(int libNum);
	public int libraryDelete(int libNum);
	public int libraryUpdate(LibraryDTO dto);
	public int libraryCount(String searchWord);
	public int libraryNumsDelete(int nums[]);
}
