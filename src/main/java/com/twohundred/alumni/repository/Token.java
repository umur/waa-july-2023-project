package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

  public String token;

  public Long issued;

  public User user;
}
