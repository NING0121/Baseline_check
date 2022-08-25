# -*- encoding: utf-8 -*-
'''
@File    :   get_service_info.py
@Time    :   2021/06/26 16:05:06
@Author  :   dilison 代宇盛 
@Version :   1.0
@Contact :   1172863239@qq.com
'''

# here put the import lib

import subprocess
import csv


def get_services():
    fp = open('services.txt', 'w', encoding='GB2312')
    services = subprocess.Popen(['sc', 'query'], shell=True, stdout=fp)
    fp.close()


def get_service_info():
    service_names = []
    display_names = []
    start_types = []
    states = []
    paths = []

    p = subprocess.Popen(['sc', 'query'], shell=True, stdout=subprocess.PIPE)
    lines = p.stdout.readlines()
    line_num = 1
    for line in lines:
        line = line.decode('GB2312')
        if line_num % 10 == 2:
            service_names.append(line.split(': ')[1][:-1])
        if line_num % 10 == 3:
            display_names.append(line.split(': ')[1][:-1])
        if line_num % 10 == 5:
            states.append(line.split(': ')[1][:-1])
        line_num += 1

    for name in service_names:
        p = subprocess.Popen(['sc', 'qc', name], shell=True, stdout=subprocess.PIPE)
        services_qc = p.stdout.readlines()
        start_type = str(services_qc[4], encoding='GB2312')
        start_types.append(start_type.split(': ')[1][:-1])
        path = str(services_qc[6], encoding='GB2312')
        paths.append(path.split(': ')[1][:-1])

    final_records = []
    for i in range(len(service_names)):
        service_name = service_names[i]
        display_name = display_names[i]
        start_type = start_types[i]
        state = states[i]
        path = paths[i]
        final_records.append({'display_name': display_name, 'service_name': service_name, 'start_type': start_type,
                              'state': state, 'binary_path_name': path})

    return final_records


def write_into_file(header, result_records):
    file = open('service_info.csv', 'w', encoding='GB2312')
    csv_writer = csv.DictWriter(file, fieldnames=header)
    csv_writer.writeheader()
    csv_writer.writerows(result_records)

    file.close()
    print("successfully write into file service_info.csv")


def main():
    results = get_service_info()
    header = ['DISPLAY_NAME', 'SERVICE_NAME', 'START_TYPE', 'STATE', 'BINARY_PATH_NAME']
    try:
        write_into_file(header, results)
    except IOError:
        print("failed to write into file service_info.csv")


if __name__ == '__main__':
    main()
