package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
private int id;
private String name;
private String description;
private TaskStatus status;
private Date deadLine;
private int userId;
}
