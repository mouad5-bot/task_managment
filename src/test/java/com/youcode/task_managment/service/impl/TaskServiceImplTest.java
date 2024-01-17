//package com.youcode.task_managment.service.impl;
//
//import com.youcode.task_managment.domain.Tag;
//import com.youcode.task_managment.domain.Task;
//import com.youcode.task_managment.repository.TaskRepository;
//import com.youcode.task_managment.repository.UserRepository;
//import com.youcode.task_managment.service.TagService;
//import com.youcode.task_managment.service.TaskService;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.TestPropertySource;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RequiredArgsConstructor
//@TestPropertySource(locations = "classpath:application.properties")
//class TaskServiceImplTest {
//
//    @Mock
//    private TaskService taskService;
//
//    @Mock
//    private TaskRepository taskRepository;
//
//    @Mock
//    private TagService tagService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    // adds a task with valid data
////    @Test
////    public void test_add_task_with_valid_data() throws Exception {
////        // Arrange
////        Task task = new Task();
////        task.setDescription("Valid task");
////        task.setExpDate(LocalDateTime.now().plusDays(3));
////        task.setCompleted(false);
////        task.setAssignedDate(LocalDateTime.now());
////        task.setHasChanged(false);
////        List<Tag> tags = new ArrayList<>();
////        tags.add(new Tag(1L,"Tag1"));
////        tags.add(new Tag(2L,"Tag2"));
////        task.setTags(tags);
////
////        Task task1 = new Task();
////        task1.setDescription("Valid task");
////        task1.setId(1L);
////        task1.setExpDate(LocalDateTime.now().plusDays(3));
////        task1.setCompleted(false);
////        task1.setAssignedDate(LocalDateTime.now());
////        task1.setHasChanged(false);
////        task1.setTags(tags);
////         when(taskService.add(task)).thenReturn(task1);
////        // Act
////        Task addedTask = taskService.add(task);
////
////        // Assert
////        assertNotNull(addedTask.getId());
////        assertEquals("Valid task", addedTask.getDescription());
////        assertFalse(addedTask.isCompleted());
////        assertEquals(LocalDateTime.now().plusDays(3), addedTask.getExpDate());
////        assertEquals(2, addedTask.getTags().size());
////    }
////
////    // adds a task with minimum required tags
////    @Test
////    public void test_add_task_with_minimum_required_tags() throws Exception {
////        // Arrange
////        Task task = new Task();
////        task.setDescription("Task with minimum required tags");
////        task.setExpDate(LocalDateTime.now().plusDays(1));
////        task.setCompleted(false);
////        task.setAssignedDate(LocalDateTime.now());
////        task.setHasChanged(false);
////        List<Tag> tags = new ArrayList<>();
////        tags.add(new Tag(1L,"Tag1"));
////        tags.add(new Tag(2L,"Tag2"));
////        task.setTags(tags);
////
////        // Act
////        Task addedTask = taskService.add(task);
////
////        // Assert
////        assertNotNull(addedTask.getId());
////        assertEquals("Task with minimum required tags", addedTask.getDescription());
////        assertFalse(addedTask.isCompleted());
////        assertEquals(LocalDateTime.now().plusDays(1), addedTask.getExpDate());
////        assertEquals(LocalDateTime.now(), addedTask.getAssignedDate());
////        assertFalse(addedTask.isHasChanged());
////        assertEquals(2, addedTask.getTags().size());
////    }
////
////    // adds a task with multiple tags
////    @Test
////    public void test_add_task_with_multiple_tags() throws Exception {
////        // Arrange
////        Task task = new Task();
////        task.setDescription("Task with multiple tags");
////        task.setExpDate(LocalDateTime.now().plusDays(3));
////        task.setCompleted(false);
////        task.setAssignedDate(LocalDateTime.now());
////        task.setHasChanged(false);
////        List<Tag> tags = new ArrayList<>();
////        tags.add(new Tag(1L,"Tag1"));
////        tags.add(new Tag(2L,"Tag2"));
////        tags.add(new Tag(3L,"Tag3"));
////        task.setTags(tags);
////
////        Task task1 = new Task();
////        task1.setDescription("Task with multiple tags");
////        task1.setId(1L);
////        task1.setExpDate(LocalDateTime.now().plusDays(3));
////        task1.setCompleted(false);
////        task1.setAssignedDate(LocalDateTime.now());
////        task1.setHasChanged(false);
////        task1.setTags(tags);
////
////        when(taskService.add(task)).thenReturn(task1);
////
////        // Act
////        Task addedTask = taskService.add(task);
////
////        // Assert
////        assertNotNull(addedTask.getId());
////        assertEquals("Task with multiple tags", addedTask.getDescription());
////        assertFalse(addedTask.isCompleted());
////        assertFalse(addedTask.isHasChanged());
////        assertEquals(3, addedTask.getTags().size());
////    }
////
////    // throws exception when adding a task with assigned date in the past
////    @Test
////    public void test_add_task_with_assigned_date_in_the_past() {
////        // Arrange
////        Task task = new Task();
////        task.setDescription("Task with assigned date in the past");
////        task.setExpDate(LocalDateTime.now().plusDays(1));
////        task.setCompleted(false);
////        task.setAssignedDate(LocalDateTime.now().minusDays(1));
////        task.setHasChanged(false);
////        List<Tag> tags = new ArrayList<>();
////        tags.add(new Tag(1L,"Tag1"));
////        tags.add(new Tag(2L,"Tag2"));
////        task.setTags(tags);
////
////        // Act and Assert
////        assertThrows(IllegalArgumentException.class, () -> taskService.add(task));
////    }
//
//    @AfterAll
//    static void afterAllMsg(){
//        System.out.println(" ------------------------------------------------------------------------------");
//        System.out.println(" ----------- All the tests of tasks are passed successfully -------------");
//        System.out.println(" ------------------------------------------------------------------------------");
//    }
//}