import pip
import imp

def main():
    packageList = [] #array to hold package name
    package_list = open('Packages.txt', 'r')
    for line in package_list:
        packageList.append(line.replace('\n', ''))
    print(packageList)
    package_list.close()
    #['pip','imp','xlwt','xlrd','xlutils']
    for i in range(len(packageList)):
        try:
            imp.find_module(packageList[i])
            found = True
            print('True')
        except ImportError:
            found = False
            print('False')
        if found == False:
            install(packageList[i])
        else:
            print('Package Already Installed.')

def install(package):
    import importlib
    try:
        importlib.import_module(package)
    except ImportError:
        import pip
        pip.main(['install', package])
    finally:
        globals()[package] = importlib.import_module(package)

main()
