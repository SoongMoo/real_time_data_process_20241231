package springProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springProject.domain.LibraryDTO;

@Mapper
public interface LibraryMapper {
	public int libraryInsert(LibraryDTO dto);
	public List<LibraryDTO> libSelectList();
	public LibraryDTO libSelectOne(int libNum);
	public int libraryDelete(int libNum);
	public int libraryUpdate(LibraryDTO dto);
}
