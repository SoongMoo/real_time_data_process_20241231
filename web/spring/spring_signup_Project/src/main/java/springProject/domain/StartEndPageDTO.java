package springProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StartEndPageDTO {
	int startRow;
	int endRow;
	String searchWord;
}
