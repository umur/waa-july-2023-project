package com.twohundred.alumni.exception;

import org.springframework.http.HttpStatus;

public class Exceptions {
        public static final ServiceException STUDENT_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS001", "Student is not found.");
        public static final ServiceException FACULTY_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS002", "Faculty is not found.");
        public static final ServiceException USER_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS003", "User is not found.");
        public static final ServiceException JOB_AD_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS004", "Job advertisement is not found.");
        public static final ServiceException UNAUTHORIZED = new ServiceException(HttpStatus.UNAUTHORIZED,
                        "SS005", "Unauthorized entity.");
        public static final ServiceException CV_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "SS006", "CV is not found.");
}
