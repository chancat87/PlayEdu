/*
 * Copyright (C) 2023 杭州白书科技有限公司
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.playedu.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import xyz.playedu.course.domain.CourseDepartmentUser;

/**
 * @author tengteng
 * @description 针对表【course_department_user】的数据库操作Service
 * @createDate 2023-02-24 14:53:52
 */
public interface CourseDepartmentUserService extends IService<CourseDepartmentUser> {

    List<Integer> getCourseIdsByDepIds(List<Integer> depIds);

    List<Integer> getDepIdsByCourseId(Integer courseId);

    void removeByCourseId(Integer courseId);

    List<Integer> getCourseIdsByDepId(Integer depId);
}
