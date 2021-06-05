import React, { useState } from 'react';
import styled from 'styled-components';
import { useDropzone } from 'react-dropzone';
import ClearIcon from '@material-ui/icons/Cancel';
import FileCopy from '@material-ui/icons/AddAPhotoOutlined';
import Paper from '@material-ui/core/Paper';
import { FundingService } from 'webapp/funding';
import { useDispatch, useSelector } from 'react-redux';
import {addFileList} from 'webapp/funding/reducer/funding.reducer'

const MAX_IMAGE_SIZE = 5 * 100000;
const ACTIVE_COLOR = '#6695ff';
// Styles
const ImagesDropZoneContainer = styled(Paper)`
  border-color: ${props =>
    (props.isactive && `${ACTIVE_COLOR} !important`) || 'none'};
  width: 130px;
  height: 130px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  flex-direction: column;
  margin: 5px;
  position: relative;
`;
const CancelIcon = styled(ClearIcon)`
  cursor: pointer;
  color: red;
  position: absolute;
  top: -7px;
  right: -7px;
`;
const ImageItem = styled.img`
  object-fit: cover;
  width: 128px;
  height: 128px;
`;
const ActiveText = styled.p`
  color: ACTIVE_COLOR;
`;
const ImageDropzone = (props, cref, getUploadedFiles, fileParam=[]) => {

  const { imageIndex, image, onDelete, onDrop, totalImages } = props;
  const { getRootProps, getInputProps } = useDropzone({
    onDrop,
    accept: 'image/*',
    maxSize: MAX_IMAGE_SIZE,
    multiple: true,
  });
  const isactive = totalImages === imageIndex;


//   const [files, setFiles] = useState([])

//   const [uploadResult, setUploadResult] = useState(fileParam)

//   const dispatch = useDispatch()

//   const windowFile = async(e) => {
//     e.preventDefault()
//     const formData = new FormData()
//     const files = e.target.files

//     for(let i = 0; i < files.length ; i++){
//         formData.append("uploadFiles", files[i])
//     }
//     FundingService.fileUpload(formData)
//     .then(res => {
//         console.log("res = " +  JSON.stringify(res))

//         res.data.forEach(uploadFileInfo =>  {uploadResult.push(uploadFileInfo)
//         dispatch(addFileList({uuid: uploadFileInfo.uuid, file: uploadFileInfo}))})

//         console.log("upload Result = " + JSON.stringify(uploadResult))

//         setUploadResult(uploadResult.slice(0))
//     })
// }


  return (
    <ImagesDropZoneContainer
      variant="outlined"
      isactive={isactive}
      {...getRootProps()}
    >
      {image == null && (
        <>
          <input {...getInputProps()} /> 
          <FileCopy
            style={{ color: isactive && ACTIVE_COLOR }}
            color="action"
          />
        </>
      )}
      {isactive && <ActiveText>Add photo</ActiveText>}
      {image && (
        <>
          <CancelIcon onClick={() => onDelete(imageIndex)} />
          <ImageItem src={window.URL.createObjectURL(image)} alt={image.name} />
        </>
      )}
    </ImagesDropZoneContainer>
  );
};
export default ImageDropzone;
