//package com.giftown.ecommerce.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.giftown.ecommerce.dto.order.OrderRequest;
//import com.giftown.ecommerce.dto.order.OrderResponseModel;
//import com.giftown.ecommerce.dto.order.OrderItemResponseModel;
//import com.giftown.ecommerce.mapper.OrderMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class OrderControllerTest {
//
//    @InjectMocks
//    private OrderController orderController;
//
//    @Mock
//    private OrderMapper orderMapper;
//
//    @Mock
//    private BindingResult bindingResult;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateOrderSuccess() throws Exception {
//        OrderRequest orderRequest = new OrderRequest();
//        orderRequest.setTotalPrice(100.0);
//        orderRequest.setFirstName("John");
//        orderRequest.setLastName("Doe");
//        orderRequest.setCity("Cityville");
//        orderRequest.setAddress("123 Main St");
//        orderRequest.setEmail("john.doe@example.com");
//        orderRequest.setPhoneNumber("1234567890");
//        orderRequest.setPostIndex(12345);
//        orderRequest.setProductId(Map.of(1L, 2L));
//
//        OrderResponseModel orderResponseModel = new OrderResponseModel();
//        // Populate the orderResponseModel with expected data
//
//        when(orderMapper.postOrder(any(OrderRequest.class), any(BindingResult.class))).thenReturn(orderResponseModel);
//
//        mockMvc.perform(post("/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(orderRequest)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.totalPrice").value(100.0))
//                .andExpect(jsonPath("$.firstName").value("John"))
//                .andExpect(jsonPath("$.lastName").value("Doe"));
//    }
//
//
//    @Test
//    public void testGetOrderById() {
//        Long orderId = 1L;
//        OrderResponseModel mockResponse = new OrderResponseModel();
//        when(orderMapper.getOrderById(orderId)).thenReturn(mockResponse);
//
//        ResponseEntity<OrderResponseModel> response = orderController.getOrderById(orderId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockResponse, response.getBody());
//    }
//
//    @Test
//    public void testGetOrderItemsByOrderId() {
//        Long orderId = 1L;
//        List<OrderItemResponseModel> mockResponse = Collections.emptyList();
//        when(orderMapper.getOrderItemsByOrderId(orderId)).thenReturn(mockResponse);
//
//        ResponseEntity<List<OrderItemResponseModel>> response = orderController.getOrderItemsByOrderId(orderId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockResponse, response.getBody());
//    }
//
//    @Test
//    public void testDeactivateOrder() {
//        Long orderId = 1L;
//        boolean deactivated = true;
//        when(orderMapper.deleteOrder(orderId)).thenReturn(deactivated);
//
//        ResponseEntity<Boolean> response = orderController.deactivateOrder(orderId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(deactivated, response.getBody());
//    }
//
//    @Test
//    public void testPostOrder() {
//        OrderRequest orderRequest = new OrderRequest();
//        OrderResponseModel mockResponse = new OrderResponseModel();
//        when(orderMapper.postOrder(orderRequest, bindingResult)).thenReturn(mockResponse);
//
//        ResponseEntity<OrderResponseModel> response = orderController.postOrder(orderRequest, bindingResult);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockResponse, response.getBody());
//    }
//}