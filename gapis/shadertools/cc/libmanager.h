/*
 * Copyright (C) 2017 Google Inc.
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

#ifndef LIBMANAGER_H_
#define LIBMANAGER_H_

#ifdef __cplusplus
extern "C" {
#endif

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

typedef struct instruction_t {
  uint32_t id;
  uint32_t opcode;
  uint32_t* words;
  uint32_t words_num;
  char* name;
} instruction_t;

typedef struct debug_instructions_t {
  instruction_t* insts;
  uint32_t insts_num;
} debug_instructions_t;

typedef struct code_with_debug_info_t {
  bool ok;
  char* message;
  char* source_code;
  char* disassembly_string;
  debug_instructions_t* info;
} code_with_debug_info_t;

/**
 * Debug options
 **/
typedef struct options_t {
  bool is_fragment_shader;
  bool is_vertex_shader;
  bool prefix_names;
  const char* names_prefix; /* optional */
  bool add_outputs_for_inputs;
  const char* output_prefix; /* optional */
  bool make_debuggable;
  bool check_after_changes;
  bool disassemble;
} options_t;

typedef struct spirv_binary_t {
    uint32_t* words;
    size_t words_num;
} spirv_binary_t;

code_with_debug_info_t* convertGlsl(const char*, size_t, const options_t*);

void deleteGlslCodeWithDebug(code_with_debug_info_t*);

const char* getDisassembleText(uint32_t*, size_t);

void deleteDisassembleText(const char*);

spirv_binary_t* assembleToBinary(const char*);

void deleteBinary(spirv_binary_t*);

const char* opcodeToString(uint32_t);

#ifdef __cplusplus
}
#endif

#endif  // LIBMANAGER_H_
