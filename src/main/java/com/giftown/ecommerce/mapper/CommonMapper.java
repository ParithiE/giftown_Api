package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.HeaderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommonMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CommonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, T> D convertToResponse(T entity, Class<D> model) {
        return modelMapper.map(entity, model);
    }

    <T, S> S convertToEntity(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }
    <T, S> List<S> convertToResponseList(List<T> lists, Class<S> type) {
        return lists.stream()
                .map(list -> convertToResponse(list, type))
                .collect(Collectors.toList());
    }

    <T, S> HeaderResponse<S> getHeaderResponse(List<T> orders, Integer totalPages, Long totalElements, Class<S> type) {
        List<S> orderResponses = convertToResponseList(orders, type);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("page-total-count", String.valueOf(totalPages));
        responseHeaders.add("page-total-elements", String.valueOf(totalElements));
        return new HeaderResponse<S>(orderResponses, responseHeaders);
    }

//    <T, S> S convertToResponse(T data, Class<S> type) {
//        return modelMapper.map(data, type);
//    }
//
//    <T, S> List<S> convertToResponseList(List<T> lists, Class<S> type) {
//        return lists.stream()
//                .map(list -> convertToResponse(list, type))
//                .collect(Collectors.toList());
//    }
}
