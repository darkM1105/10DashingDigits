drop table game_sessions;
drop table word_lists;

create table word_lists (
  list_id INT AUTO_INCREMENT NOT NULL,
  file_path VARCHAR(100) NOT NULL,
  PRIMARY KEY (list_id)
);

create table game_sessions (
  session_id INT AUTO_INCREMENT NOT NULL,
  file_path VARCHAR(100) NOT NULL,
  wl_list_id INT NOT NULL,
  PRIMARY KEY (session_id),
  CONSTRAINT fk_list_id FOREIGN KEY(wl_list_id) REFERENCES word_lists(list_id)
);
