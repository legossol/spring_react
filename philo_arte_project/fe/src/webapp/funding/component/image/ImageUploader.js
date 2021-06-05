import React, { useState, Fragment, useCallback, useImperativeHandle } from 'react';
import styled from 'styled-components';
import ImageDropzone from './ImageDropzone';
import shortid from 'shortid';

const MAX_NUMBER_IMAGES = 5;

const ImagesDropZoneContainer = styled.div`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin-bottom: 30px;
  margin-top: 10px;
`;



const ImagesUploader = ({cref, getUploadedFiles, fileParam=[]}) => {

  const [imagesData, setImages] = useState([]);
  const [uploadResult, setUploadResult] = useState(fileParam)
  debugger;

  const onDrop = useCallback(acceptedFiles => {
      debugger;
      setImages([...imagesData, ...acceptedFiles]);
    },
    [imagesData]
  );
    useImperativeHandle(cref,()=>({
      send(){
        getUploadedFiles(imagesData)
        setImages([])
      }
    }))
  //   const onDrop = useCallback(acceptedFiles => {
  //     debugger;
  //     setImages([...imagesData, ...acceptedFiles]);
  //     const formData = new FormData()
  //     const imagesData = acceptedFiles.target.imagesData
  //     for(let i = 0; i < imagesData.length ; i++){
  //       formData.append("uploadFiles", imagesData[i])
  //   }
  //   FundingService.fileUpload(formData)
  //   },
  //   [imagesData]
  // );
  const handleDelete = useCallback(
    index => {
      if (index === 0 && !imagesData.length > 1) {
        debugger;
        setImages([]);
      } else {
        debugger;
        setImages(imagesData.filter((img, indx) => indx !== index));
      }
    },
    [imagesData]
  );

  const renderDropzones = useCallback(() => {
    const Dropzones = [];
    for (let i = 0; i < MAX_NUMBER_IMAGES; i++) {
      Dropzones.push(
        <ImageDropzone
          onDrop={onDrop}
          key={shortid.generate()}
          imageIndex={i}
          image={imagesData[i] || null}
          onDelete={handleDelete}
          totalImages={imagesData.length}
        />
      );
    }
    return Dropzones;
  }, [imagesData, handleDelete, onDrop]);




  return (
    <Fragment>
      <ImagesDropZoneContainer>{renderDropzones()}</ImagesDropZoneContainer>
    </Fragment>
  );
};

export default ImagesUploader;
