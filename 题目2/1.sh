#!/bin/bash  
  
# 检查参数数量(字符内容 文件 输出文件 )
if [ "$#" -ne 3 ]; then  
    echo "Usage: $0 <search_string> <input_file> <output_file>"  
    exit 1  
fi  
  
# 获取参数  
search_string="$1"  
input_file="$2"  
output_file="$3"  
  
# 检查输入文件是否存在  
if [ ! -f "$input_file" ]; then  
    echo "Input file not found!"  
    exit 1  
fi  
  
# 搜索并输出结果  
grep -n "$search_string" "$input_file" | tee "$output_file"  

#打印到控制台
cat "$output_file"