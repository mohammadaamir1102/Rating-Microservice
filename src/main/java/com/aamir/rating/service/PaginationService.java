package com.aamir.rating.service;



import com.aamir.rating.dto.PaginationDTO;
import com.aamir.rating.exception.ServiceException;
import org.springframework.data.domain.Pageable;

public interface PaginationService {
    Pageable getPagination(PaginationDTO paginationDTO) throws ServiceException;

}
