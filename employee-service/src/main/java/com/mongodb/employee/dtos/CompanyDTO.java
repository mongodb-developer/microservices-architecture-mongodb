package com.mongodb.employee.dtos;

import java.util.Date;

public record CompanyDTO(String id, String name, String headquarters, Date created) {

}
