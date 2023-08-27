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
package xyz.playedu.common.service;

import com.baomidou.mybatisplus.extension.service.IService;

import xyz.playedu.common.domain.AppConfig;
import xyz.playedu.common.types.config.MinioConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppConfigService extends IService<AppConfig> {

    Map<String, Long> allKeys();

    List<AppConfig> allShow();

    void saveFromMap(HashMap<String, String> data);

    Map<String, String> keyValues();

    MinioConfig getMinioConfig();
}